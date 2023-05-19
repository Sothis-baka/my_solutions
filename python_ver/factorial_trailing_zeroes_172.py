class Solution:
    def trailingZeroes(self, n: int) -> int:
        prod_5, result = 5, 0

        while prod_5 <= n:
            result += n // prod_5
            prod_5 *= 5

        return result
