package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

    public boolean solution(int courses, int[][] preReq) {
        HashMap<Integer, ArrayList<Integer>> coursesMap = new HashMap<>(courses);
        for(int i=0; i<preReq.length; i++){
            if(coursesMap.containsKey(preReq[i][0])) {
                coursesMap.get(preReq[i][0]).add(preReq[i][1]);
            } else {
                ArrayList<Integer> existing = new ArrayList<>();
                existing.add(preReq[i][1]);
                coursesMap.put(preReq[i][0], existing);
            }
        }
        boolean[] completed = new boolean[courses];
        for(int i=0; i<courses; i++) {
            if(!completed[i]) {
                HashSet<Integer> path = new HashSet<>();
                path.add(i);
                if(!completeCourse(i, coursesMap, completed,path)){
                    return false;
                }
            }
        }
        for(int i=0; i<courses; i++) {
            if(!completed[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean completeCourse(int course, HashMap<Integer, ArrayList<Integer>> coursesMap, boolean[] completed, HashSet<Integer> path) {
        for(int c : coursesMap.getOrDefault(course, new ArrayList<>())) {
            if(path.contains(c) && !completed[c]) {
                return false;
            }
            if(!completed[c]) {
                path.add(c);
                if(!completeCourse(c, coursesMap, completed, path)){
                    return false;
                }
            }
        }
        completed[course] = true;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.solution(5, new int[][]{{0,1},{0,2},{1,3},{1,4},{3,4}}));
    }
}
