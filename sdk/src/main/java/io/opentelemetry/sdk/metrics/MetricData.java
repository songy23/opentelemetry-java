/*
 * Copyright 2019, OpenTelemetry Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opentelemetry.sdk.metrics;

import com.google.auto.value.AutoValue;
import io.opentelemetry.common.Timestamp;
import javax.annotation.concurrent.Immutable;

/**
 * A {@link MetricData} represents the data exported as part of aggregating one {@code Metric}.
 *
 * @since 0.1.0
 */
@Immutable
@AutoValue
public abstract class MetricData {
  MetricData() {}

  /**
   * Returns the {@link MetricDescriptor} of this metric.
   *
   * @return the {@code MetricDescriptor} of this metric.
   * @since 0.1.0
   */
  public abstract MetricDescriptor getMetricDescriptor();

  /**
   * Returns the start {@link Timestamp} of this {@code Metric}, usually the time when the metric
   * was created or an aggregation was enabled.
   *
   * @return the start {@code Timestamp}.
   * @since 0.1.0
   */
  public abstract Timestamp getStartTimestamp();

  /**
   * Returns the {@link Timestamp} when data were collected, usually it represents the moment when
   * {@code Metric.getData()} was called.
   *
   * @return the start {@code Timestamp}.
   * @since 0.1.0
   */
  public abstract Timestamp getTimestamp();

  // TODO: Add TimeSeries/Point

  static MetricData createInternal(
      MetricDescriptor metricDescriptor, Timestamp startTimestamp, Timestamp timestamp) {
    return new AutoValue_MetricData(metricDescriptor, startTimestamp, timestamp);
  }
}
