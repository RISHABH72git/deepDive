class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList(object):
    def __init__(self):
        self.head = None

    def add(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    def traverse(self):
        current = self.head
        while current:
            print(current.data)
            current = current.next

    def is_empty(self):
        return self.head is None

    def peek(self):
        if self.is_empty():
            raise Exception('List is empty')
        return self.head.data

    def pop(self):
        if self.is_empty():
            raise Exception('List is empty')
        current = self.head
        self.head = current.next
        current.next = None
        return current.data

    def remove(self, data):
        if self.is_empty():
            raise Exception('List is empty')
        if self.head.data == data:
            self.head = self.head.next
            return self.head.data

        current = self.head
        while current and current.next:
            if current.next.data == data and current.next.next:
                current.next = current.next.next
            elif current.next.data == data:
                current.next = None

            current = current.next

        return self.head.data


if __name__ == "__main__":
    llist = LinkedList()
    llist.add(1)
    llist.add(2)
    llist.add(3)
    llist.add(4)
    # llist.traverse()
    # print("element deleted :", llist.pop())
    llist.remove(3)
    llist.traverse()
