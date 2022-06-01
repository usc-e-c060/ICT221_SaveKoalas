/**



//add player to random position on map
    Random random = new Random();
            player.setPlayerRow(random.nextInt(engine.getSize()));
            player.setPlayerCol(random.nextInt(engine.getSize()));
            pane.add(cell[player.getPlayerRow()][player.getPlayerCol()] = player, player.getPlayerCol(),
            player.getPlayerRow());



 */