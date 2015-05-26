package View;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * A helper class to make GridBagConstraints simpler to construct
 * 
 * @author Cay Horstmann in Core Java, Volume 1: Fundamentals
 * @author Reagan Middlebrook (a few tiny changes marked at their methods)
 *
 */
public class GBC extends GridBagConstraints{
	/**
	 * Constructs a GBC with given gridx and gridy and all other
	 * constraint values set to default
	 * @author Reagan (added default weight)
	 * 
	 * @param gridx the row position
	 * @param gridy the column position
	 */
	public GBC(int gridx, int gridy){
		this.gridx = gridx;
		this.gridy = gridy;
		this.weightx = 100;
		this.weighty = 100;
	}
	
	/**
	 * Constructs a GBC as above but also including gridwidth and gridheight
	 * @author Reagan (added default weight)
	 * 
	 * @param gridx the row position
	 * @param gridy the column position
	 * @param gridw the rows to span
	 * @param gridh the columns to span
	 */
	public GBC(int gridx, int gridy, int gridw, int gridh){
		this.gridx = gridx;
		this.gridy = gridy;
		gridwidth = gridw;
		gridheight = gridh;
		this.weightx = 100;
		this.weighty = 100;
	}
	
	/**
	 * Sets the anchor
	 * 
	 * @param anchor the anchor value
	 * @return this object for further modification
	 */
	public GBC setAnchor(int anchor){
		this.anchor = anchor;
		return this;
	}
	
	/**
	 * Sets the fill direction
	 * 
	 * @param fill the fill direction
	 * 
	 * @return this object for further modification
	 */
	public GBC setFill(int fill){
		this.fill = fill;
		return this;
	}
	
	/**
	 * Sets the cell weights
	 * @param weightx the weight in x-direction
	 * @param weighty the weight in y-direction
	 * @return this object for further modification
	 */
	public GBC setWeight(double weightx, double weighty){
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	/**
	 * Sets the insets of this cell to a uniform distance
	 * @param distance the spacing to use in all directions
	 * @return this object for further modification
	 */
	public GBC setInsets(int distance){
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	/**
	 * Sets the insets of this cell to custom distances
	 * @param top the spacing to use on top
	 * @param left spacing to use on the left
	 * @param bottom spacing to use on the bottom
	 * @param right spacing to use on the right
	 * @return this object for further modification
	 */
	public GBC setInsets(int top, int left, int bottom, int right){
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}
	
	/**
	 * Sets the internal padding
	 * 
	 * @param padx padding in the x-direction
	 * @param pady padding in the y-direction
	 * @return this object for further modification
	 */
	public GBC setPad(int padx, int pady){
		ipadx = padx;
		ipady = pady;
		return this;
	}
}
