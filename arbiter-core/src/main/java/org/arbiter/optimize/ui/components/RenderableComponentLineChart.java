/*
 *
 *  * Copyright 2016 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */
package org.arbiter.optimize.ui.components;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RenderableComponentLineChart extends RenderableComponent {
    public static final String COMPONENT_TYPE = "linechart";

    private RenderableComponentLineChart(Builder builder){
        super(COMPONENT_TYPE);
        title = builder.title;
        x = builder.x;
        y = builder.y;
        seriesNames = builder.seriesNames;
    }

    public RenderableComponentLineChart(){
        super(COMPONENT_TYPE);
        //no-arg constructor for Jackson
    }

    private String title;
    private List<double[]> x;
    private List<double[]> y;
    private List<String> seriesNames;



    public static class Builder {

        private String title;
        private List<double[]> x = new ArrayList<>();
        private List<double[]> y = new ArrayList<>();
        private List<String> seriesNames = new ArrayList<>();

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder addSeries(String seriesName, double[] xValues, double[] yValues){
            x.add(xValues);
            y.add(yValues);
            seriesNames.add(seriesName);
            return this;
        }

        public RenderableComponentLineChart build(){
            return new RenderableComponentLineChart(this);
        }

    }

}