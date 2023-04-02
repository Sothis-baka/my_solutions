from typing import List
from collections import defaultdict


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        height, width, word_l = len(board), len(board[0]), len(word)

        board_dict, word_dict = defaultdict(lambda: 0), defaultdict(lambda: 0)
        for entry in board:
            for cell in entry:
                board_dict[cell] += 1

        for ch in word:
            word_dict[ch] += 1

        for key in word_dict.keys():
            if board_dict[key] < word_dict[key]:
                return False

        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        visited = set()

        def dfs(row: int, col: int, w_index: int):
            # fully matched
            if w_index == word_l:
                return True

            # invalid
            if not 0 <= row < height or not 0 <= col < width or board[row][col] != word[w_index] or (
                    row, col) in visited:
                return False

            visited.add((row, col))
            for del_row, del_col in dirs:
                new_row, new_col = row + del_row, col + del_col

                if dfs(new_row, new_col, w_index + 1):
                    return True

            visited.remove((row, col))
            return False

        for i in range(height):
            for j in range(width):
                if dfs(i, j, 0):
                    return True

        return False
