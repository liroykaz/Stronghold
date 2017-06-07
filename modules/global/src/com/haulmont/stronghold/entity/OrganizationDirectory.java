package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.validation.constraints.NotNull;

@NamePattern("%s %s %s|orgEmail,orgName,orgAddress")
@Table(name = "STRONGHOLD_ORGANIZATION_DIRECTORY")
@Entity(name = "stronghold$OrganizationDirectory")
public class OrganizationDirectory extends StandardEntity {
    private static final long serialVersionUID = -2800072698846168127L;

    @NotNull
    @Column(name = "ORG_NAME", nullable = false)
    protected String orgName;

    @Column(name = "ORG_ADDRESS")
    protected String orgAddress;

    @Column(name = "ORG_EMAIL")
    protected String orgEmail;

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgEmail() {
        return orgEmail;
    }


}