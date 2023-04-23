index_a = ord('a')


class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.is_word = False

    def insert(self, word: str) -> None:
        pt = self

        for ch in word:
            index = ord(ch) - index_a
            if not pt.children[index]:
                pt.children[index] = Trie()

            pt = pt.children[index]

        pt.is_word = True

    def search(self, word: str) -> bool:
        pt = self

        for ch in word:
            index = ord(ch) - index_a
            if not pt.children[index]:
                return False

            pt = pt.children[index]

        return pt.is_word

    def startsWith(self, prefix: str) -> bool:
        pt = self

        for ch in prefix:
            index = ord(ch) - index_a
            if not pt.children[index]:
                return False

            pt = pt.children[index]

        return True
