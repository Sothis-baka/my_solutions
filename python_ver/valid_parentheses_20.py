class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {
            ')': '(',
            ']': '[',
            '}': '{'
        }

        for ch in s:
            match ch:
                case '(' | '[' | '{':
                    stack.append(ch)
                case ')' | ']' | '}':
                    if len(stack) == 0 or stack.pop() != pairs[ch]:
                        return False

        return len(stack) == 0

