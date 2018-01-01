public class GreedyScheduler {
    public class Schedule {
        public int start;
        public int end;
        public Schedule(int s, int e) {
            start = s;
            end = e;
        }
        public String toString() {
            return "start=" + start + " end=" + end;
        }
    }
    
    public static boolean canFitClass(Schedule schedule, int s, int e) {
        return schedule.start >= s && schedule.end <= e;
    }
    
    public static void schedule(Schedule[] schedules, int s, int e) {
        int cur = s;
        for ( Schedule sched : schedules ) {
            if (canFitClass(sched, cur, e)) {
                cur = sched.end;
                System.out.printf("Schedule=%s\n", sched.toString());
            }
        }
    }
}