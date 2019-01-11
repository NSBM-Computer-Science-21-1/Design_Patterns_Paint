package commands;

import model.DrawingModel;
import shapes.Shape;

/**
 * Class that represent command to bring some shape to the front.
 */
public class CmdBringToFront implements Command {
	private DrawingModel model;
	private Shape shape;
	private int index;
	private int size;
	
	public CmdBringToFront(DrawingModel model, Shape shape, int size) {
		this.model = model;
		this.shape = shape;
		this.size = size;
	}

	/**
	 * Get index of shape, remove it from that place, add it to the last place and add that command to the log.
	 */
	@Override
	public void execute() {
		index =  model.getIndexOfShape(shape);
		model.removeShapeAtIndex(index);
		model.addShapeToIndex(size, shape);
	}

	/**
	 * Remove shape from last place, return it to the previous (original) position, and remove command from the log.
	 */
	@Override
	public void unexecute() {
		model.removeShapeAtIndex(model.getAll().size() - 1);
		model.addShapeToIndex(index, shape);
	}
}