public class Feed {
	private long id = 0;
	private String name;
	private String siteUrl;
	private String feedUrl;
	private FeedType feedType;
	private boolean customCheckIntervalEnabled = false;
	private Integer checkInterval;

	public Feed() {
	}

	public Feed(String name, String siteUrl, String feedUrl, FeedType feedType) {
		this.name = name;
		this.siteUrl = siteUrl;
		this.feedUrl = feedUrl;
		this.feedType = feedType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String newSiteUrl) {
		this.siteUrl = newSiteUrl;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String newFeedUrl) {
		this.feedUrl = newFeedUrl;
	}

	public FeedType getFeedType() {
		return feedType;
	}

	public void setFeedType(FeedType newFeedType) {
		this.feedType = newFeedType;
	}

	public boolean isCustomCheckIntervalEnabled() {
		return customCheckIntervalEnabled;
	}

	public void setCustomCheckIntervalEnabled(boolean newCustomCheckIntervalEnabled) {
		this.customCheckIntervalEnabled = newCustomCheckIntervalEnabled;
	}

	public Integer getCheckInterval() {
		return checkInterval;
	}

	public void setCheckInterval(Integer newCheckInterval) {
		this.checkInterval = newCheckInterval;
	}

	public String toString() {
		return this.name;
	}
}

class FeedType {
	private String type;

	private FeedType(String type) {
		this.type = type;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FeedType))
			return false;

		final FeedType feedType = (FeedType) o;

		if (type != null ? !type.equals(feedType.type) : feedType.type != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (type != null ? type.hashCode() : 0);
	}

	public String toString() {
		return this.type;
	}
}
