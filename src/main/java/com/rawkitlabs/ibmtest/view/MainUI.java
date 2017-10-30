package com.rawkitlabs.ibmtest.view;

import java.util.ArrayList;
import java.util.List;

import com.rawkitlabs.ibmtest.model.Article;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.ItemClickListener;

@SpringUI
public class MainUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		// setContent(new Label(greeter.sayHello()));
		final VerticalLayout layout = new VerticalLayout();

		layout.setMargin(true);
		setContent(layout);

		HorizontalLayout horiz = new HorizontalLayout();
		horiz.addStyleName("outlined");

		List<Article> dataContainer = new ArrayList<Article>();
		dataContainer.add(new Article("2014", "Build a reactive sales chart with Meteor",
				"http://www.ibm.com/developerworks/library/wa-bluemix-meteor-app/index.html"));
		dataContainer.add(new Article("2014", "3D development with WebGL, Part 3",
				"http://www.ibm.com/developerworks/web/library/wa-webgl3/"));
		dataContainer.add(new Article("2014", "3D development with WebGL, Part 2",
				"http://www.ibm.com/developerworks/web/library/wa-webgl2/"));
		dataContainer.add(new Article("2013", "3D development with WebGL, Part 1",
				"http://www.ibm.com/developerworks/web/library/wa-webgl1/"));
		dataContainer.add(new Article("2006", "Introduction to Apache Maven 2",
				"http://www.ibm.com/developerworks/java/tutorials/j-mavenv2/"));
		dataContainer.add(new Article("2003", "Taming your Tomcat: Filtering tricks for Tomcat 5",
				"https://www.ibm.com/developerworks/library/j-tomcat2"));
		dataContainer.add(new Article("2002", "Rock'em Sock'em Robocode",
				"http://www.ibm.com/developerworks/library/j-robocode/"));
		dataContainer.add(new Article("2002", "Rock'em Sock'em Robocode: Round 2",
				"http://www.ibm.com/developerworks/library/j-robocode2/"));
		Grid<Article> grid = new Grid(Article.class);

		grid.setColumns("year", "title");
		grid.setCaption("Select Article");
		grid.setItems(dataContainer);

		horiz.setSizeFull();
		horiz.addComponent(grid);

		final Embedded e = new Embedded("Article view", new ExternalResource(dataContainer.get(0).getLink()));
		e.setAlternateText("Article View");
		e.setType(Embedded.TYPE_BROWSER);
		e.setSizeFull();
		horiz.addComponent(e);
		horiz.setExpandRatio(e, 1);

		grid.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClick event) {
				Article itemArticle = (Article) event.getItem();
				System.out.println("Link is " + itemArticle.getLink());
				e.setSource(new ExternalResource(itemArticle.getLink()));
			}
		});

		layout.setSizeFull();
		layout.addComponent(horiz);
		layout.setExpandRatio(horiz, 1);
	}

	protected Object[] getRowData(Object[] row) {
		return new Object[] { row[0], row[1] };
	}
}
