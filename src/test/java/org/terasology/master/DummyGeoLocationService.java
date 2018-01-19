/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.master;

import java.io.IOException;
import org.terasology.web.services.geo.GeoLocation;
import org.terasology.web.services.geo.GeoLocationService;

/**
 * A dummy implementation of {@link GeoLocationService}.
 */
public class DummyGeoLocationService implements GeoLocationService {

    @Override
    public GeoLocation resolve(String hostnameOrIp) throws IOException {
        return new GeoLocation() {

            @Override
            public String getStateOrProvince() {
                return "myState";
            }

            @Override
            public String getCountry() {
                return "EuropeanUnion";
            }

            @Override
            public String getCity() {
                return "myCity";
            }

            @Override
            public String getAddress() {
                return "myAddress";
            }
        };
    }
}
