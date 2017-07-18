/**
 * Copyright 2016 StreamSets Inc.
 *
 * Licensed under the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.stage.processor.kudulookup;

import com.streamsets.pipeline.api.*;
import com.streamsets.pipeline.configurablestage.DProcessor;
import com.streamsets.pipeline.stage.destination.kudu.Groups;

@StageDef(
    version = 1,
    label = "Kudu Lookup",
    description = "Performs KV lookups to enrich records",
    icon = "kudu.png",
    privateClassLoader = true,
    upgrader = KuduProcessorUpgrader.class,
    onlineHelpRefUrl = "TODO"
)

@ConfigGroups(Groups.class)
@GenerateResourceBundle
public class KuduLookupDProcessor extends DProcessor {
  @ConfigDefBean(groups = {"LOOKUP", "KUDU"})
  public KuduLookupConfig conf;

  @Override
  protected Processor createProcessor() {
    return new KuduLookupProcessor(conf);
  }
}
