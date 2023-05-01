package TaskOne;

// Конкретная фабрика для кистей художников
class ArtistBrushFactory implements BrushFactory {
    public Brush createBrush() {
        return new ArtistBrush();
    }
}
