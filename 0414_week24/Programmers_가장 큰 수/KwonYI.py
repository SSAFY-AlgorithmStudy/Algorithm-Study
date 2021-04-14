def solution(numbers):
    numbers = list(map(str, numbers));
    numbers.sort(key = lambda x : int((x * 4)[:4]), reverse = True)
    return str(int("".join(numbers)))