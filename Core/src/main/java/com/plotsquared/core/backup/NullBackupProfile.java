/*
 *       _____  _       _    _____                                _
 *      |  __ \| |     | |  / ____|                              | |
 *      | |__) | | ___ | |_| (___   __ _ _   _  __ _ _ __ ___  __| |
 *      |  ___/| |/ _ \| __|\___ \ / _` | | | |/ _` | '__/ _ \/ _` |
 *      | |    | | (_) | |_ ____) | (_| | |_| | (_| | | |  __/ (_| |
 *      |_|    |_|\___/ \__|_____/ \__, |\__,_|\__,_|_|  \___|\__,_|
 *                                    | |
 *                                    |_|
 *            PlotSquared plot management system for Minecraft
 *               Copyright (C) 2014 - 2022 IntellectualSites
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.plotsquared.core.backup;

import com.plotsquared.core.player.PlotPlayer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Backup profile for a plot without an owner
 * {@inheritDoc}
 */
public class NullBackupProfile implements BackupProfile {

    @Override
    public @NonNull CompletableFuture<List<Backup>> listBackups() {
        return CompletableFuture.completedFuture(Collections.emptyList());
    }

    @Override
    public void destroy() {
    }

    @Override
    public @NonNull Path getBackupDirectory() {
        return new File(".").toPath();
    }

    @Override
    public @NonNull CompletableFuture<Backup> createBackup() {
        throw new UnsupportedOperationException("Cannot create backup of an unowned plot");
    }

    @Override
    public @NonNull CompletableFuture<Void> restoreBackup(final @NonNull Backup backup, @Nullable PlotPlayer<?> player) {
        return CompletableFuture.completedFuture(null);
    }

}
