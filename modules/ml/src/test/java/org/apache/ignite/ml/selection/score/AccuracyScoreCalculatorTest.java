/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.ml.selection.score;

import java.util.Arrays;
import org.apache.ignite.ml.selection.score.util.TruthWithPredictionCursor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link AccuracyScoreCalculator}.
 */
public class AccuracyScoreCalculatorTest {
    /** */
    @Test
    public void testScore() {
        ScoreCalculator<Integer> scoreCalculator = new AccuracyScoreCalculator<>();

        TruthWithPredictionCursor<Integer> cursor = new TestTruthWithPredictionCursor<>(
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(1, 1, 0, 1)
        );

        double score = scoreCalculator.score(cursor.iterator());

        assertEquals(0.75, score, 1e-12);
    }
}