class Queue:
    def __init__(self):
        self.queue = []

    def push(self, item):
        self.queue.append(item)

    def pop(self):
        if self.is_empty():
            raise IndexError('Queue is empty')
        return self.queue.pop(0)

    def peek(self):
        if self.is_empty():
            raise IndexError('Queue is empty')
        return self.queue[0]

    def is_empty(self):
        return len(self.queue) == 0

    def size(self):
        return len(self.queue)

if __name__ == '__main__':
    q = Queue()
    q.push(1)
    q.push(2)
    q.push(3)
    print(q.peek())
    q.pop()
    print(q.peek())