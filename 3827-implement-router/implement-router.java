class Router {

    private int MAX_SIZE;  // memory limit
    private Map<String, int[]> packetStore;          // key -> packet {source, dest, timestamp}
    private Map<Integer, ArrayList<Integer>> destTimestamps;  // destination -> timestamps
    private Map<Integer, Integer> startIndex;        // destination -> index of first valid timestamp
    private Queue<String> que;                       // FIFO queue for packets

    public Router(int memoryLimit) {
        MAX_SIZE = memoryLimit;
        packetStore = new HashMap<>();
        destTimestamps = new HashMap<>();
        startIndex = new HashMap<>();
        que = new LinkedList<>();
    }

    private String makeKey(int source, int destination, int timestamp) {
        return source + "#" + destination + "#" + timestamp;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = makeKey(source, destination, timestamp);

        if (packetStore.containsKey(key)) return false; // duplicate

        if (packetStore.size() >= MAX_SIZE) {
            forwardPacket(); // evict oldest
        }

        packetStore.put(key, new int[]{source, destination, timestamp});
        que.offer(key);

        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destTimestamps.get(destination).add(timestamp);

        startIndex.putIfAbsent(destination, 0);

        return true;
    }

    public int[] forwardPacket() {
        if (packetStore.isEmpty()) return new int[0];

        String key = que.poll();
        int[] packet = packetStore.get(key);
        packetStore.remove(key);

        int dest = packet[1];
        int idx = startIndex.get(dest);
        startIndex.put(dest, idx + 1); // move start index forward instead of removing from list

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;

        ArrayList<Integer> list = destTimestamps.get(destination);
        int idx = startIndex.get(destination);
        int left = lowerBound(list, startTime, idx);
        int right = upperBound(list, endTime, idx);

        return right - left;
    }

    // binary search for first index >= target, starting from startIdx
    private int lowerBound(ArrayList<Integer> list, int target, int startIdx) {
        int low = startIdx, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    // binary search for first index > target, starting from startIdx
    private int upperBound(ArrayList<Integer> list, int target, int startIdx) {
        int low = startIdx, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) > target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}