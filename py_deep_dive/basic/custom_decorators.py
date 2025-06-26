import time
from functools import wraps

_cached = {}


def measure_time(function):
    @wraps(function)
    def timed(*args, **kw):
        ts = time.time()
        result = function(*args, **kw)
        print(f"{function.__name__} took {time.time() - ts:.2f} seconds")
        return result

    return timed


def logged(function):
    @wraps(function)
    def logged_wrap(*args, **kw):
        print(f"calling {function.__name__} with {args} {kw}")
        result = function(*args, **kw)
        print(f"{function.__name__} returned: {result}")
        return result

    return logged_wrap


def retry(max_retries=3, delay=3):
    def decorator(function):
        @wraps(function)
        def wrapper(*args, **kw):
            for i in range(max_retries):
                try:
                    return function(*args, **kw)
                except Exception as e:
                    print(f"{e} {function.__name__} failed (attempt {i + 1}), retrying...")
                    time.sleep(delay)
            raise Exception("Max retries exceeded")

        return wrapper

    return decorator


def cached(function):
    @wraps(function)
    def cached_wrap(*args):
        if args in _cached:
            return _cached[args]

        result = function(*args)
        _cached[args] = result
        return result

    return cached_wrap


def required_auth(role="user"):
    def decorator(function):
        @wraps(function)
        def wrapper(*args, **kw):
            if role == "guest":
                raise PermissionError("You are not allowed to access this resource")
            return function(*args, **kw)

        return wrapper

    return decorator


def only_once(function):
    is_called = False

    @wraps(function)
    def wrapper(*args, **kw):
        nonlocal is_called
        if is_called:
            print(f"{function.__name__} has already been called.")
            return None
        is_called = True
        return function(*args, **kw)

    return wrapper


def validate_input(expected_type):
    def decorator(function):
        @wraps(function)
        def wrapper(*args, **kw):
            for arg in args:
                if not isinstance(arg, expected_type):
                    raise ValueError(f"Invalid type: {arg} is not {expected_type}")
            return function(*args, **kw)

        return wrapper

    return decorator


if __name__ == "__main__":
    print("common decorators")
