/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class SelectionController 
{
	private boolean subscribeToEmailNotif;
	private boolean showOnlineStatus;
	private boolean recievePrivateMsgs;
	
	private List<String>  tags;
	private Map<String, String> popularTags = null;
	private List<String>  selectedTags;
	private List<String>  favoriteTags;
	private List<String>  selectedPopularTags;
	
	private List<Tag> tagPojos;
	private List<Tag> selectedTagsFromPojos;
	
	private String gender;
	private List<String> servers;
	private String selectedServer;
	private Tag selectedTag;
	
	private boolean value1;  
    private boolean value2;  
  
    public SelectionController() 
    {
    	tags = new ArrayList<String>();
    	tags.add("JSF");
    	tags.add("PrimeFaces");
    	//tags.add("Spring");
    	tags.add("JPA");
    	//tags.add("EJB");
    	tags.add("jQuery");
    	
    	popularTags = new HashMap<String, String>();
    	popularTags.put("Java","java");
    	//popularTags.put("JavaEE","java-ee");
    	popularTags.put("JavaScript","javascript");
    	//popularTags.put("JSF","jsf");
    	popularTags.put("PrimeFaces","primefaces");
    	
    	tagPojos = new ArrayList<Tag>();
    	tagPojos.add(new Tag(1, "JavaSE", "java-se", "Java Programming Language"));
    	tagPojos.add(new Tag(2, "JavaEE", "java-ee", "Java Enterproze Edition"));
    	tagPojos.add(new Tag(3, "Spring", "spring", "Spring Framework"));
    	
    	servers = new ArrayList<String>();
    	servers.add("Tomcat");
    	servers.add("Glassfish");
    	servers.add("JBoss");
    	
	}
    
    public boolean isValue1() {  
        return value1;  
    }  
  
    public void setValue1(boolean value1) {  
        this.value1 = value1;  
    }  
  
    public boolean isValue2() {  
        return value2;  
    }  
  
    public void setValue2(boolean value2) {  
        this.value2 = value2;  
    }  
    
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public String getSelectedServer() {
		return selectedServer;
	}

	public void setSelectedServer(String selectedServer) {
		this.selectedServer = selectedServer;
	}

	public Tag getSelectedTag() {
		return selectedTag;
	}

	public void setSelectedTag(Tag selectedTag) {
		this.selectedTag = selectedTag;
	}

	public boolean isSubscribeToEmailNotif() {
		return subscribeToEmailNotif;
	}

	public void setSubscribeToEmailNotif(boolean subscribeToEmailNotif) {
		this.subscribeToEmailNotif = subscribeToEmailNotif;
	}
	
	public boolean isShowOnlineStatus() {
		return showOnlineStatus;
	}

	public void setShowOnlineStatus(boolean showOnlineStatus) {
		this.showOnlineStatus = showOnlineStatus;
	}

	public boolean isRecievePrivateMsgs() {
		return recievePrivateMsgs;
	}

	public void setRecievePrivateMsgs(boolean recievePrivateMsgs) {
		this.recievePrivateMsgs = recievePrivateMsgs;
	}

	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getSelectedTags() {
		return selectedTags;
	}

	public void setSelectedTags(List<String> selectedTags) {
		this.selectedTags = selectedTags;
	}

	public List<String> getFavoriteTags() {
		return favoriteTags;
	}

	public void setFavoriteTags(List<String> favoriteTags) {
		this.favoriteTags = favoriteTags;
	}
	public Map<String, String> getPopularTags() {
		return popularTags;
	}
	
	public List<String> getSelectedPopularTags() {
		return selectedPopularTags;
	}

	public void setSelectedPopularTags(List<String> selectedPopularTags) {
		this.selectedPopularTags = selectedPopularTags;
	}

	public void setPopularTags(Map<String, String> popularTags) {
		this.popularTags = popularTags;
	}
	public List<Tag> getTagPojos() {
		return tagPojos;
	}
	
	public List<Tag> getSelectedTagsFromPojos() {
		return selectedTagsFromPojos;
	}

	public void setSelectedTagsFromPojos(List<Tag> selectedTagsFromPojos) {
		this.selectedTagsFromPojos = selectedTagsFromPojos;
	}

	public void setTagPojos(List<Tag> tagPojos) {
		this.tagPojos = tagPojos;
	}

	public void handleEmailSubscription()
	{
		if(subscribeToEmailNotif){
			addMessage("You have subscribed to Email notifications");
		} else {
			addMessage("You have unsubscribed from Email notifications");
		}
	}
	
	public void updateUserpreferences() {
		String msg = "Show Online Status : "+showOnlineStatus+", "+"Accept Private Msgs : "+recievePrivateMsgs;
		addMessage(msg);
	}
	
	public void handleSelectMany() {
		String msg = "Selected Values";
		msg += "<br/>FavoriteTags : "+ StringUtils.join(favoriteTags, ", ");
		msg += "<br/>Popular Tags : "+ StringUtils.join(selectedPopularTags, ", ");
		msg += "<br/>Selected Tags : "+ StringUtils.join(selectedTags, ",");
		List<String> tagList = new ArrayList<String>();
		if(selectedTagsFromPojos != null){
			for (Tag tag : selectedTagsFromPojos) {
				tagList.add(tag.getLabel());
			}
		}
		msg += "<br/>Selected Tags(POJO) : "+ StringUtils.join(tagList, ", ");
		addMessage(msg);
	}

	

	public void addMessage() {  
        String summary = value2 ? "Checked" : "Unchecked";  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));  
    }

	public void addMessage(String summary) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));  
    }
	
}
