import socket
import ipaddress
import concurrent.futures
import uuid

COMMON_PORTS = [22, 80, 443, 3389, 3000, 8000, 5000, 8080]


def get_local_subnet():
    hostname = socket.gethostname()
    local_ip = socket.gethostbyname(hostname)
    print(f"Local IP: {local_ip}")
    subnet = ".".join(local_ip.split(".")[:3]) + ".0/24"
    return subnet


def try_resolve_ip(ip):
    try:
        hostname, _, _ = socket.gethostbyaddr(str(ip))
        return f"{ip}"
    except socket.herror:
        return None


def scan_network(subnet):
    ips = list(ipaddress.IPv4Network(subnet, strict=False).hosts())
    found = []
    with concurrent.futures.ThreadPoolExecutor(max_workers=100) as executor:
        results = executor.map(try_resolve_ip, ips)
        for result in results:
            if result:
                found.append(result)
    return found

def is_port_open(ip, port, timeout=0.5):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.settimeout(timeout)
        try:
            s.connect((str(ip), port))
            return True
        except:
            return False

def client_send_command(cmd):
    with socket.create_connection(("127.0.0.1", 6379)) as sock:
        sock.sendall((cmd + "\r\n").encode())
        print(sock.recv(4096).decode())

if __name__ == "__main__":
    # subnet = get_local_subnet()
    # mac = ':'.join(['{:02x}'.format((uuid.getnode() >> ele) & 0xff)
    #                 for ele in range(0,8*6,8)][::-1])
    # print(f"MAC: {mac}")
    # print(f"Scanning subnet: {subnet} ...")
    # results = scan_network(subnet)
    # for r in results:
    #     print(r)
    #     for p in COMMON_PORTS:
    #         if is_port_open(str(r), p):
    #             print(f"Port {p} is open in {r}")
    client_send_command("GET hike")
    client_send_command("SET mykey hello")
    client_send_command("GET mykey")
    client_send_command("EXISTS mykey")
    client_send_command("DEL mykey")
    client_send_command("GET mykey")
    client_send_command("QUIT")
    client_send_command("QU")
