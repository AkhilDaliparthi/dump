package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule2 {

    public int[] solution(int courses, int[][] preReq) {
        HashMap<Integer, ArrayList<Integer>> coursesMap = new HashMap<>(courses);
        int[] order = new int[courses];
        if(preReq.length==0) {
            for(int i=courses-1; i>=0; i--) {
                order[courses-i-1]= i;
            }
            return order;
        }
        for(int i=0; i<preReq.length; i++){
            if(coursesMap.containsKey(preReq[i][0])) {
                coursesMap.get(preReq[i][0]).add(preReq[i][1]);
            } else {
                ArrayList<Integer> existing = new ArrayList<>();
                existing.add(preReq[i][1]);
                coursesMap.put(preReq[i][0], existing);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] completed = new boolean[courses];
        for(int i:coursesMap.keySet()) {
            if(!completed[i]) {
                HashSet<Integer> path = new HashSet<>();
                path.add(i);
                if(completeCourse(i, coursesMap, completed,path, res).size()==0){
                    return new int[]{};
                }
            }
        }
        for(int i=0; i<courses; i++) {
            if (!completed[i] && coursesMap.containsKey(i)) {
                return new int[]{};
            }
            if(!completed[i]){
                res.add(i);
            }
        }
        for(int i=res.size()-1; i>=0; i--) {
            order[i] = res.get(i);
        }
        return order;
    }

    public ArrayList<Integer> completeCourse(int course, HashMap<Integer, ArrayList<Integer>> coursesMap, boolean[] completed, HashSet<Integer> path, ArrayList<Integer> res) {
        for(int c : coursesMap.getOrDefault(course, new ArrayList<>())) {
            if(path.contains(c) && !completed[c]) {
                return new ArrayList<>();
            }
            if(!completed[c]) {
                path.add(c);
                if(completeCourse(c, coursesMap, completed, path, res).size()==0){
                    return new ArrayList<>();
                }
            }
        }
        completed[course] = true;
        res.add(course);
        return res;
    }

    public static void main(String[] args) {
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int[] res = courseSchedule2.solution(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for(int i: res) {
            System.out.print(i+"\t");
        }
    }
}
