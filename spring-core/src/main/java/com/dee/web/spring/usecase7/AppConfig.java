package com.dee.web.spring.usecase7;

/**
 * @author dien.nguyen
 **/

public class AppConfig {
    
    private boolean cleanDb;
    
    private String version;
    
    private String profile;

    public boolean isCleanDb() {
        return cleanDb;
    }

    public void setCleanDb(boolean cleanDb) {
        this.cleanDb = cleanDb;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
}
