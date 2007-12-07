/*
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * Kune is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.platf.client.ui.rate;

import org.ourproject.kune.platf.client.services.Kune;
import org.ourproject.kune.platf.client.services.Images;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.Widget;

public class RateItPanel extends Composite implements ClickListener, RateItView {
    private Grid rateGrid;
    private Image[] starImg;
    private Label rateDesc;
    private final Images img = Images.App.getInstance();
    private final RateItPresenter presenter;
    private Label rateItLabel;

    public RateItPanel(final RateItPresenter presenter) {
        this.presenter = presenter;
        initialize();
        layout();
        setProperties();
    }

    private void initialize() {
        rateItLabel = new Label(Kune.I18N.t("Rate it:"));
        rateGrid = new Grid(1, 7);
        starImg = new Image[5];
        rateDesc = new Label();
        for (int i = 0; i < 5; i++) {
            starImg[i] = new Image();
            img.starGrey().applyTo(starImg[i]);
            starImg[i].addStyleName("rateit-star");
            starImg[i].setStyleName("rateit-star");
            starImg[i].addClickListener(this);
            starImg[i].addMouseListener(new MouseListenerAdapter() {
                public void onMouseLeave(final Widget sender) {
                    presenter.revertCurrentRate();
                }

                public void onMouseEnter(final Widget sender) {
                    for (int i = 0; i < 5; i++) {
                        if (sender == starImg[i]) {
                            presenter.starOver(i);
                        }
                    }

                }
            });
        }
    }

    private void layout() {
        initWidget(rateGrid);
        rateGrid.setWidget(0, 0, rateItLabel);
        for (int i = 0; i < 5; i++) {
            rateGrid.setWidget(0, i + 1, starImg[i]);
        }
        rateGrid.setWidget(0, 6, rateDesc);
    }

    private void setProperties() {
        rateGrid.setCellPadding(0);
        rateGrid.setCellSpacing(0);
        rateGrid.setBorderWidth(0);
        rateItLabel.addStyleName("kune-Margin-Medium-r");
        rateItLabel.addStyleName("kune-Margin-Medium-l");
        rateItLabel.addStyleName("kune-RatePanel-Label");
        rateGrid.addStyleName("kune-RatePanel-Stars");
        rateGrid.addStyleName("kune-RatePanel-Stars-RateIt");
        rateDesc.addStyleName("kune-RatePanel-Label");
        rateDesc.addStyleName("kune-Margin-Medium-l");
    }

    public void onClick(final Widget sender) {
        for (int i = 0; i < 5; i++) {
            if (sender == starImg[i]) {
                presenter.starClicked(i);
            }
        }
    }

    public void setRate(final Star stars[]) {
        for (int i = 0; i < 5; i++) {
            stars[i].getImage().applyTo(starImg[i]);
        }
    }

    public void clearRate() {
        for (int i = 0; i < 5; i++) {
            img.starGrey().applyTo(starImg[i]);
        }
    }

    public void setStars(final Double rate) {
        setRate(Star.genStars(rate.doubleValue()));
    }

    public void setDesc(final String desc) {
        rateDesc.setText(desc);
    }
}
