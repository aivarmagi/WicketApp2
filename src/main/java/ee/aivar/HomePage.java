package ee.aivar;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private int counter = 0;

	public HomePage() {
		IModel<Integer> counterModel = new AbstractReadOnlyModel<Integer>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer getObject() {
				return counter;
			}
		};

		final Label label = new Label("counter", counterModel);
		add(label.setOutputMarkupId(true));

		final AjaxFallbackLink<Void> link = new AjaxFallbackLink<Void>("increment") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter++;
				if (target != null) target.add(label);
			}
		};
		add(link);
	}
}