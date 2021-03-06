/**
 * 
 */
package com.bhuwan.advancejaxrs.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bhuwan.advancejaxrs.messanger.DatabaseClass;
import com.bhuwan.advancejaxrs.messanger.model.Profile;

/**
 * @author bhuwan
 *
 */
public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("Bhuwan", new Profile(1, "Bhuwan", "Bhuwan", "Gautam"));
        profiles.put("Prisha", new Profile(2, "Prisha", "Prisha", "Gautam"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
