class Solution {
    static class ClassInfo {
        int p, t;       
        double gain;    

        ClassInfo(int p, int t) {
            this.p = p;
            this.t = t;
            this.gain = calcGain(p, t);
        }

        static double calcGain(int p, int t) {
            return (double) (p + 1) / (t + 1) - (double) p / t;
        }

        void addOne() {
            p++;
            t++;
            gain = calcGain(p, t);
        }

        double ratio() {
            return (double) p / t;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain, a.gain)
        );
        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }
        for (int i = 0; i < extraStudents; i++) {
            ClassInfo best = pq.poll();
            best.addOne();
            pq.offer(best);
        }
        double sum = 0.0;
        for (ClassInfo ci : pq) {
            sum += ci.ratio();
        }
        return sum / classes.length;
    }
}
