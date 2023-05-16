class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        cur_s, cur_count = '', 0

        for ch in s:
            if ch.isdigit():
                cur_count = cur_count * 10 + int(ch)
            elif ch == '[':
                stack.append(cur_s)
                stack.append(cur_count)
                cur_s, cur_count = '', 0
            elif ch == ']':
                prev_count = stack.pop()
                prev_s = stack.pop()
                cur_s = prev_s + cur_s * prev_count
            else:
                cur_s += ch

        return cur_s
