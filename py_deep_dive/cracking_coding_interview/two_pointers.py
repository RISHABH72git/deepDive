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


if __name__ == '__main__':
    print(has_pair_with_sum([1, 2, 4, 6, 10], 18))
