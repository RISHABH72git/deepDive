def count_up_to(n):
    counter = 0
    while counter <= n:
        yield counter
        counter += 1


def even_numbers(start, end):
    while start <= end + 1:
        if start % 2 == 0:
            yield start
        start += 1


def range_step(start, end, step=1):
    while start <= end:
        yield start
        start += step


def chunk_generator(lst, size):
    for i in range(0, len(lst), size):
        yield lst[i:i + size]


def fibonacci(n):
    a, b = 0, 1
    while a < n:
        yield a
        a, b = b, a + b


if __name__ == '__main__':
    for count in fibonacci(100):
        print(count)
