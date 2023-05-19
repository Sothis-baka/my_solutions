import math


class Solution:
    def calculate(self, s: str) -> int:
        val, op, entries = 0, '+', []

        s += '.'
        for ch in s:
            if ch.isdigit():
                val = 10 * val + int(ch)
            elif ch == ' ':
                pass
            else:
                if op == '+':
                    entries.append(val)
                elif op == '-':
                    entries.append(-val)
                elif op == '*':
                    entries[-1] *= val
                elif op == '/':
                    entries[-1] = math.trunc(entries[-1] / val)

                val = 0
                op = ch

        return sum(entries)
