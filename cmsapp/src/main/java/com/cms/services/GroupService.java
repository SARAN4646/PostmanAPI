package com.cms.services;
import java.util.HashMap;
import java.util.Map;

import com.cms.models.Group;

public class GroupService {
    private Map<Integer, Group> groups = new HashMap<>();
    private int nextGroupId = 1;

    public Group getGroup(int groupId) {
        return groups.get(groupId);
    }

    public Map<Integer, Group> getAllGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        group.setId(nextGroupId++);
        groups.put(group.getId(), group);
    }

    public void updateGroup(Group group) {
        if (groups.containsKey(group.getId())) {
            groups.put(group.getId(), group);
        } else {
            // Handle error - Group does not exist
        }
    }

    public void deleteGroup(int groupId) {
        groups.remove(groupId);
    }
}
