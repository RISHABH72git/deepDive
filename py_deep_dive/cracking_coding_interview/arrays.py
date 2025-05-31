import time


class Arrays:
    def __init__(self):
        print("Arrays was initialize..")

    def string_has_unique_characters(self, characters):
        unique = {}
        for i in characters:
            if unique.get(i):
                return False
            unique[i] = i
        return True

    def string_has_unique_characters_without_ds(self, characters):
        count = 0
        for i in characters:
            rem = characters[0:count] + characters[count+1:len(characters)]
            if i in rem:
                return False
            count+=1
        return True


if __name__ == "__main__":
    print("Hello World")
    arrays = Arrays()
    print(arrays.string_has_unique_characters_without_ds("hello"))
