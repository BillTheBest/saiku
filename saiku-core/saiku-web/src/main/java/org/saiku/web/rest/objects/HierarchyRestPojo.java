package org.saiku.web.rest.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.saiku.olap.dto.SaikuHierarchy;
import org.saiku.olap.dto.SaikuLevel;
import org.saiku.olap.dto.SaikuMember;
import org.saiku.web.rest.util.RestList;

@XmlRootElement(name="hierarchies")
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyRestPojo extends AbstractRestObject {

	@XmlAttribute(name = "hierarchy", required = false)
	private String name;
	
	@XmlAttribute(name = "uniqueName", required = false)
	private String uniqueName;
	
	@XmlAttribute(name = "caption", required = false)
	private String caption;
	
	@XmlAttribute(name = "dimension", required = false)
	private String dimensionUniqueName;

	@XmlElement(name = "levels", required = false)	
        private RestList<LevelRestPojo> levels;
	
	public HierarchyRestPojo(){
		throw new RuntimeException("Unsupported Constructor. Serialization only");
	}

	public HierarchyRestPojo(String name, String uniqueName, String caption, String dimensionUniqueName, RestList<LevelRestPojo> levels) {
		this.name = name;
		this.uniqueName = uniqueName;
		this.caption = caption;
		this.dimensionUniqueName = dimensionUniqueName;
		this.levels = levels;
	}
	
	public String getUniqueName() {
		return uniqueName;
	}
	public String getCaption() {
		return caption;
	}
	public String getDimensionUniqueName() {
		return dimensionUniqueName;
	}

	public String getName() {
		return name;
	}

	@Override
	public SaikuHierarchy toNativeObject() {
		return new SaikuHierarchy(name, uniqueName, caption, dimensionUniqueName, getSaikuHierachyList());
	}

	public List<SaikuLevel> getSaikuHierachyList() {
		List<SaikuLevel> levelList = new ArrayList<SaikuLevel>();
		for (LevelRestPojo level : levels) {
			levelList.add(level.toNativeObject());
		}
		return levelList;
	}

	
	@Override
	public String getCompareValue() {
		return getName();
	}

	@Override
	public String toString() {
		return getName();
	}

	public void setLevels(List<LevelRestPojo> levels) {
		
	}
}