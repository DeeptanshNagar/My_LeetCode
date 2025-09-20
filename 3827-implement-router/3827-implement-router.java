import java.util.*;

class Router {
    int size;
    Map<Long, List<Integer>> packets;
    Map<Integer, List<Integer>> counts;
    Queue<Long> q;

    public Router(int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.q = new LinkedList<>();
    }

    public long encode(int source, int destination, int timestamp) {
        return ((long) source << 40) | ((long) destination << 20) | timestamp;
    }

    public int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        long key = encode(source, destination, timestamp);

        if (packets.containsKey(key))
            return false;

        if (packets.size() >= size)
            forwardPacket();

        packets.put(key, Arrays.asList(source, destination, timestamp));
        q.add(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    public List<Integer> forwardPacket() {
        if (packets.isEmpty()) return Collections.emptyList();

        long key = q.poll();
        List<Integer> packet = packets.remove(key);

        int dest = packet.get(1);
        counts.get(dest).remove(0);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!counts.containsKey(destination) || counts.get(destination).isEmpty())
            return 0;

        List<Integer> list = counts.get(destination);

        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);

        return right - left;
    }
}
