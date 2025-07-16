"""
 * Leetcode 362: Design Hit Counter. Python. Medium.
 * O(1) time complexity for both hit() and getHits() operations, O(1) space complexity
 * Uses circular array to efficiently track hits in the last 300 seconds.
 *
 * Example:
 * hit(1)
 * hit(2)
 * hit(3)
 * getHits(4)   # returns 3
 * hit(300)
 * getHits(300) # returns 4
 * getHits(301) # returns 3
 *
 * 7/12/2025 Winston Tsui
"""

class HitCounter:
    def __init__(self):
        # Circular buffer to store timestamps and counts
        # Each index represents a timestamp % 300
        self.latestTs = [0] * 300  # Store the latest timestamp for each bucket
        self.count = [0] * 300     # Store the count of hits for each bucket

    def hit(self, timestamp: int) -> None:
        """Record a hit at the given timestamp."""
        index = timestamp % 300
        
        # If the timestamp is more than 300 seconds old, reset the count
        if self.latestTs[index] <= timestamp - 300:
            self.latestTs[index] = timestamp
            self.count[index] = 1
        else:
            # Otherwise, increment the count for this timestamp
            self.count[index] += 1

    def getHits(self, timestamp: int) -> int:
        """Return the number of hits in the past 300 seconds."""
        hits = 0
        for i in range(300):
            # Only count hits that are within the last 300 seconds
            if timestamp - self.latestTs[i] < 300:
                hits += self.count[i]
        return hits
