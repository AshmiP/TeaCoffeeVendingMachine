package com.yash.containers;

public interface Container {

	public Integer getContainerQuantity();

	public Integer updateContainerQuantity(Integer consumedTea);

	public Integer refillContainerQuantity(Integer requiredFill);

	public Integer resetContainerQuantity();

}
