import socket
import threading

in_memory_db = {}


def handle_client(sock):
    with sock:
        while True:
            data = sock.recv(1024)
            if not data:
                break
            print(f"incoming data {data}")
            command = data.decode().strip().split()
            if not command:
                sock.sendall(b"-ERR empty command\r\n")
                continue

            cmd = command[0].upper()

            if cmd == "SET" and len(command) == 3:
                key, value = command[1], command[2]
                in_memory_db[key] = value
                sock.sendall(b"+OK\r\n")

            elif cmd == "GET" and len(command) == 2:
                key = command[1]
                if key in in_memory_db:
                    value = in_memory_db[key]

                    sock.sendall(f"${len(value)}\r\n{value}\r\n".encode())
                else:
                    sock.sendall(b"$-1\r\n")

            elif cmd == "DEL" and len(command) == 2:
                key = command[1]
                if key in in_memory_db:
                    del in_memory_db[key]
                    sock.sendall(b":1\r\n")
                else:
                    sock.sendall(b":0\r\n")

            elif cmd == "EXISTS" and len(command) == 2:
                key = command[1]
                if key in in_memory_db:
                    sock.sendall(b":1\r\n")
                else:
                    sock.sendall(b":0\r\n")
            elif cmd == "QUIT" and len(command) == 2:
                sock.sendall(b"+BYE\r\n")
                break
            else:
                sock.sendall(b"-ERR unknown command\r\n")


def start_server(host='localhost', port=6379):
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((host, port))
    server.listen(5)
    print(f"Redis-like server started on {host}:{port}")
    try:
        while True:
            client_sock, addr = server.accept()
            print(f"Accepted connection from {addr}")
            threading.Thread(target=handle_client, args=(client_sock,)).start()
    except Exception as ex:
        print("error occurred ", ex)

    finally:
        server.close()


if __name__ == "__main__":
    start_server()
