/*
 * Minify Maven Plugin
 * https://github.com/samaxes/minify-maven-plugin
 *
 * Copyright (c) 2009 samaxes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sevenprinciplesmobility.maven.minify.common;

import java.util.List;

/**
 * Maps aggregations from an external JSON formatted config file defined in the option {@code bundleConfiguration}.
 */
public class AggregationConfiguration {

    private List<Aggregation> bundles;

    /**
     * Creates a new AggregationConfiguration object
     */
    public AggregationConfiguration() {
        super();
    }

    /**
     * Gets the bundles.
     *
     * @return the bundles
     */
    public List<Aggregation> getBundles() {
        return bundles;
    }

    /**
     * Sets the bundles.
     *
     * @param bundles the bundles to set
     */
    public void setBundles(List<Aggregation> bundles) {
        this.bundles = bundles;
    }
}
