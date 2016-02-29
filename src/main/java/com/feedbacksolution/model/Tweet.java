package com.feedbacksolution.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Description:
 *
 * @author Created by deepmistry
 *         2/23/16.
 */

@Document(collection = "testTweet")
public class Tweet {

    @Id
    private String _id;

    private String twitterId;

    private String name;

    private String screenName;

    private String filterLevel;

    private String retweeted;

    private String lang;

    private String timestampMs;

    private Date createdAt;

    private Long retweetCount;

    private Long favoritesCount;

    private Long friendsCount;

    private Long followersCount;

    private Long statusesCount;

    private String text;

    private Boolean favorited;

    private Boolean rewteeted;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getFilterLevel() {
        return filterLevel;
    }

    public void setFilterLevel(String filterLevel) {
        this.filterLevel = filterLevel;
    }

    public String getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(String retweeted) {
        this.retweeted = retweeted;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(String timestampMs) {
        this.timestampMs = timestampMs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Long getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Long favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public Long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public Long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getRewteeted() {
        return rewteeted;
    }

    public void setRewteeted(Boolean rewteeted) {
        this.rewteeted = rewteeted;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "_id=" + _id +
                ", twitterId='" + twitterId + '\'' +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", filterLevel='" + filterLevel + '\'' +
                ", retweeted='" + retweeted + '\'' +
                ", lang='" + lang + '\'' +
                ", timestampMs='" + timestampMs + '\'' +
                ", createdAt=" + createdAt +
                ", retweetCount=" + retweetCount +
                ", favoritesCount=" + favoritesCount +
                ", friendsCount=" + friendsCount +
                ", followersCount=" + followersCount +
                ", statusesCount=" + statusesCount +
                ", text='" + text + '\'' +
                ", favorited=" + favorited +
                ", rewteeted=" + rewteeted +
                '}';
    }
}
