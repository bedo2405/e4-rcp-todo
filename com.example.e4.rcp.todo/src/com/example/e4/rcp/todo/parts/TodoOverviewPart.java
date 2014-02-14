package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class TodoOverviewPart {

	@Inject
	public TodoOverviewPart(Composite parent) {
		// assuming that dependency injection works
		// parent will never be null
		System.out.println("Woh! Got a Composite via DI.");

		// does it have a layout manager?
		System.out.println("Layout: " + parent.getLayout().getClass());
	}

	@PostConstruct
	public void createControls(Composite parent, EMenuService menuService) {
		System.out.println(this.getClass().getSimpleName()
				+ " @PostConstruct method called.");
		
	    // more code...
	    TableViewer viewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);
	    
	    // more code
	    
	    // register context menu on the table
	    menuService.registerContextMenu(viewer.getControl(), 
	        "com.example.e4.rcp.todo.popupmenu.table");
	}
}
