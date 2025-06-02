class Arrays:
    def __init__(self):
        print("Arrays was initialize..")

    @staticmethod
    def string_has_unique_characters(characters):
        unique = {}
        for i in characters:
            if unique.get(i):
                return False
            unique[i] = i
        return True

    @staticmethod
    def string_has_unique_characters_without_ds(characters):
        count = 0
        for i in characters:
            rem = characters[0:count] + characters[count + 1:len(characters)]
            if i in rem:
                return False
            count += 1
        return True

    @staticmethod
    def check_permutation_given_two_strings(string1, string2):
        if len(string1) != len(string2):
            return False
        sorted1 = sorted(string1)
        sorted2 = sorted(string2)
        for i in range(len(sorted1)):
            if sorted1[i] != sorted2[i]:
                return False
        return True

    @staticmethod
    def check_permutation_given_two_strings_without_sorted(string1, string2):
        if len(string1) != len(string2):
            return False
        str_feq = {}
        for i in string1:
            if i in str_feq:
                str_feq[i] = str_feq.get(i)+1
            else:
                str_feq[i] = 1

        for i in string2:
            if i in str_feq:
                str_feq[i] = str_feq.get(i) - 1
            else:
                return False

        return True

    @staticmethod
    def urify_the_string(demo):
        new_demo = ''
        pre_counter = ''
        for i in demo:
            if i == " " and pre_counter != '%20':
                new_demo += "%20"
                pre_counter = '%20'
            elif i != " ":
                new_demo += i
                pre_counter = i
        print(new_demo)


if __name__ == "__main__":
    print("Hello World")
    arrays = Arrays()
    print(arrays.urify_the_string(" Mr hi    this  "))
