class TaskManager {
    
    public final Map<Integer, int[]> taskMap = new HashMap<>();
    
    public final TreeSet<int[]> priorityQueue = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) {
            return b[0] - a[0];
        }
        return b[1] - a[1];
    });
    
    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[] {userId, priority});
        priorityQueue.add(new int[] {priority, taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        int[] taskInfo = taskMap.get(taskId);
        int userId = taskInfo[0];
        int oldPriority = taskInfo[1];
        
        priorityQueue.remove(new int[] {oldPriority, taskId});
        priorityQueue.add(new int[] {newPriority, taskId});
        taskMap.put(taskId, new int[] {userId, newPriority});
    }
    
    public void rmv(int taskId) {
        int[] taskInfo = taskMap.remove(taskId);
        int priority = taskInfo[1];
        priorityQueue.remove(new int[] {priority, taskId});
    }
    
    public int execTop() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        
        int[] topTask = priorityQueue.pollFirst();
        int taskId = topTask[1];
        
        int[] taskInfo = taskMap.remove(taskId);
        int userId = taskInfo[0];
        return userId;
    }
}