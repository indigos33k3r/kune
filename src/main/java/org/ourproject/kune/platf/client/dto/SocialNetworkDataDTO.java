/*
 *
 * Copyright (C) 2007-2008 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.ourproject.kune.platf.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SocialNetworkDataDTO implements IsSerializable {

    private SocialNetworkVisibilityDTO socialNetworkVisibility;
    private SocialNetworkDTO groupMembers;
    private ParticipationDataDTO userParticipation;
    private UserBuddiesVisibilityDTO userBuddiesVisibility;
    private UserBuddiesDataDTO userBuddies;
    private AccessRightsDTO groupRights;
    private boolean isBuddiesVisible;
    private boolean isMembersVisible;

    public SocialNetworkDataDTO() {
        this(null, null, null, null, null, null, false, false);
    }

    public SocialNetworkDataDTO(SocialNetworkVisibilityDTO socialNetworkVisibility,
            final SocialNetworkDTO groupMembers, final ParticipationDataDTO userParticipation,
            UserBuddiesVisibilityDTO userBuddiesVisibility, final UserBuddiesDataDTO userBuddies,
            AccessRightsDTO groupRights, boolean isBuddiesVisible, boolean isMembersVisible) {
        this.socialNetworkVisibility = socialNetworkVisibility;
        this.groupMembers = groupMembers;
        this.userParticipation = userParticipation;
        this.userBuddiesVisibility = userBuddiesVisibility;
        this.userBuddies = userBuddies;
        this.groupRights = groupRights;
        this.isBuddiesVisible = isBuddiesVisible;
        this.isMembersVisible = isMembersVisible;
    }

    public SocialNetworkDTO getGroupMembers() {
        return groupMembers;
    }

    public AccessRightsDTO getGroupRights() {
        return groupRights;
    }

    public boolean getIsBuddiesVisible() {
        return isBuddiesVisible;
    }

    public boolean getIsMembersVisible() {
        return isMembersVisible;
    }

    public SocialNetworkVisibilityDTO getSocialNetworkVisibility() {
        return socialNetworkVisibility;
    }

    public UserBuddiesDataDTO getUserBuddies() {
        return userBuddies;
    }

    public UserBuddiesVisibilityDTO getUserBuddiesVisibility() {
        return userBuddiesVisibility;
    }

    public ParticipationDataDTO getUserParticipation() {
        return userParticipation;
    }

    public boolean isBuddiesVisible() {
        return isBuddiesVisible;
    }

    public boolean isMembersVisible() {
        return isMembersVisible;
    }

    public void setBuddiesVisible(boolean isBuddiesVisible) {
        this.isBuddiesVisible = isBuddiesVisible;
    }

    public void setGroupMembers(final SocialNetworkDTO groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void setGroupRights(AccessRightsDTO groupRights) {
        this.groupRights = groupRights;
    }

    public void setIsBuddiesVisible(boolean isBuddiesVisible) {
        setBuddiesVisible(isBuddiesVisible);
    }

    public void setIsMembersVisible(boolean isMembersVisible) {
        setMembersVisible(isMembersVisible);
    }

    public void setMembersVisible(boolean isMembersVisible) {
        this.isMembersVisible = isMembersVisible;
    }

    public void setSocialNetworkVisibility(SocialNetworkVisibilityDTO socialNetworkVisibilityDTO) {
        this.socialNetworkVisibility = socialNetworkVisibilityDTO;
    }

    public void setUserBuddies(UserBuddiesDataDTO userBuddies) {
        this.userBuddies = userBuddies;
    }

    public void setUserBuddiesVisibility(UserBuddiesVisibilityDTO userBuddiesVisibilityDTO) {
        this.userBuddiesVisibility = userBuddiesVisibilityDTO;
    }

    public void setUserParticipation(final ParticipationDataDTO userParticipation) {
        this.userParticipation = userParticipation;
    }

    @Override
    public String toString() {
        return "SocialNetworkResultDTO[members: " + groupMembers + "; participation: " + userParticipation + "]";
    }
}
