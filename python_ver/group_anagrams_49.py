from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        cache = defaultdict(list)

        for entry in strs:
            mask = ''.join(sorted(entry))
            cache[mask].append(entry)

        return list(cache.values())
