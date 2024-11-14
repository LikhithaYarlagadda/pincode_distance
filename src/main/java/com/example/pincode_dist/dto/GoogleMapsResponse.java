package com.example.pincode_dist.dto;

import java.util.List;

public class GoogleMapsResponse {
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public static class Route {
        private OverviewPolyline overviewPolyline;
        private List<Leg> legs;

        public OverviewPolyline getOverviewPolyline() {
            return overviewPolyline;
        }

        public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
            this.overviewPolyline = overviewPolyline;
        }

        public List<Leg> getLegs() {
            return legs;
        }

        public void setLegs(List<Leg> legs) {
            this.legs = legs;
        }

        public static class OverviewPolyline {
            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class Leg {
            private TextValue distance;
            private TextValue duration;

            public TextValue getDistance() {
                return distance;
            }

            public TextValue getDuration() {
                return duration;
            }

            public void setDistance(TextValue distance) {
                this.distance = distance;
            }

            public void setDuration(TextValue duration) {
                this.duration = duration;
            }

            public static class TextValue {
                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}
