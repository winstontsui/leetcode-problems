"""
 * Leetcode 1396: Design Underground System. Python. Medium.
 * O(1) time complexity for all operations, O(P + S^2) space where P is passengers and S is stations.
 * Maintains two dictionaries to track check-ins and travel statistics.
 *
 * Input:
 * ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
 * [[],[45,"Times Square",4],[45,"Grand Central",10],["Times Square","Grand Central"],[45,"Times Square",6],[45,"Grand Central",16],["Times Square","Grand Central"]]
 * Output: [null,null,null,6.0,null,null,8.0]
 *
 * 6/25/2025 Winston Tsui
"""

class UndergroundSystem:
    """
    checkIn(45, "Times Square", 4)
    checkOut(45, "Grand Central", 10)
    getAverageTime("Times Square", "Grand Central") -> 6
    
    checkIn 
    station_map = {id1: [stationName, start_time],
            id2: [stationName, start_time],
            ...}

    checkOut remove id in hashmap. 
    station_from_to = {id1: [total time from start to end, count],
    "Times Square Grand Central": [0, 0]
    "Times Square Grand Central": [6, 1]
    }
    """
    def __init__(self):
        self.station_map = {}  # id: (startStation, startTime)
        self.station_from_to = {}  # "startStation endStation": [totalTime, tripCount]

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.station_map[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        station_from_name, start_time = self.station_map.pop(id)
        total_time, trip_count = self.station_from_to.get(station_from_name + " " + stationName, (0,0))
        total_time += t - start_time
        trip_count += 1
        self.station_from_to[station_from_name + " " + stationName] = (total_time, trip_count)

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        entry = self.station_from_to.get(startStation + " " + endStation)
        return entry[0] / entry[1]

# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
