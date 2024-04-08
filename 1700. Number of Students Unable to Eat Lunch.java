class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sand = new Stack<>();
        List<Integer> stu = new ArrayList<>();
        boolean check;
        int x, i;
        for(i = sandwiches.length-1; i>=0; i--) sand.push(sandwiches[i]);
        for(i = 0; i < students.length; i++) stu.add(students[i]);
        while (!sand.isEmpty()) {
            check = false;
            x = sand.pop();
            for (i=0;i<stu.size();i++) if (stu.get(i) == x) {
                stu.remove(i);
                check = true;
                break;
            }
            if (!check) return stu.size();
        }
        return 0;
    }
}
