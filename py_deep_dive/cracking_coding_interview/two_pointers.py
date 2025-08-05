def has_pair_with_sum(arr, target):
    left = 0
    right = len(arr) - 1
    while left < right:
        sm = arr[left] + arr[right]
        if sm == target:
            return True
        if sm < target:
            left += 1
        else:
            right -= 1
    return False


def remove_duplicates_sorted(arr):
    i = 0
    for j in range(1, len(arr)):
        if arr[i] != arr[j]:
            i += 1
            arr[i] = arr[j]

    return arr[:i + 1]


def reverse_string(s):
    left = 0
    right = len(s) - 1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1
    return s


if __name__ == '__main__':
    print(has_pair_with_sum([1, 2, 4, 6, 10], 18))
    print(remove_duplicates_sorted([1, 2, 2, 2, 4, 5]))
    print(reverse_string(list("hello")))
